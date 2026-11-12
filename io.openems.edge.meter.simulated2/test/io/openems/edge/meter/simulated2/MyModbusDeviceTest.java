package io.openems.edge.meter.simulated2;

import org.junit.Test;

import io.openems.common.test.DummyConfigurationAdmin;
import io.openems.common.types.MeterType;
import io.openems.edge.bridge.modbus.test.DummyModbusBridge;
import io.openems.edge.common.test.AbstractComponentTest.TestCase;
import io.openems.edge.common.test.ComponentTest;

public class MyModbusDeviceTest {

	private static final String COMPONENT_ID = "component0";
	private static final String MODBUS_ID = "modbus0";
	//private static final String MODBUS_TARGET = "modbustargetid"
	
	@Test
	public void test() throws Exception {
		new ComponentTest(new MeterSimulated2Impl()) //
				.addReference("cm", new DummyConfigurationAdmin()) //
				.addReference("setModbus", new DummyModbusBridge(MODBUS_ID)) //
				.activate(MyConfig.create() //
						.setId(COMPONENT_ID) //
						.setModbusId(MODBUS_ID) //
						.setType(MeterType.GRID) // 
						.build()) //
				.next(new TestCase()) //
				.deactivate();
	}

}
