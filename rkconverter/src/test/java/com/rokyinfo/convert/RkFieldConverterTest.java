package com.rokyinfo.convert;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YuanZhiJian on 16/5/1.
 */
public class RkFieldConverterTest {



    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testEntity2bytes() throws Exception {

        DeviceInfo mDeviceInfo = new DeviceInfo();
        mDeviceInfo.setModel("RK4100");
        mDeviceInfo.setVersionCode(68);
        byte[] bytes = RkFieldConverter.entity2bytes(mDeviceInfo);

        assertArrayEquals(new byte[]{82,75,52,49,48,48,0,68},bytes);

    }

    @Test
    public void testBytes2entity() throws Exception {

        byte[] bytes = new byte[]{82,75,52,49,48,48,0,68};
        DeviceInfo mDeviceInfo = new DeviceInfo();
        mDeviceInfo = RkFieldConverter.bytes2entity(mDeviceInfo,bytes);

        assertEquals("RK4100",mDeviceInfo.getModel());
        assertEquals(68,mDeviceInfo.getVersionCode());

    }
}