## 简介
为了高效传输，物联网项目通常采用了二进制协议来进行数据交换。

RkConverter库的目标是让开发从低效、重复、无技术含量的二进制报文解析中解放出来专注于业务和协议变化。
## 用法
### 字节数组转对象
蓝牙设备返回了设备信息字节数组为`{82,75,52,49,48,48,0,68}`数据交换解析协议为
![][image-1]

只需要两步即可将字节数组转换为需要的对象

1、为DeviceInfo对象属性添加RkField注解描述解析规则

{% codeblock lang:java %}
	public class DeviceInfo {
	
	    @RkField(position = 0,length = 6)
	    private String model;
	
	    @RkField(position = 6,length = 2)
	    private int versionCode;
	
	    public String getModel() {
	        return model;
	    }
	
	    public void setModel(String model) {
	        this.model = model;
	    }
	
	    public int getVersionCode() {
	        return versionCode;
	    }
	
	    public void setVersionCode(int versionCode) {
	        this.versionCode = versionCode;
	    }
	}
{% endcodeblock %}
	
2、调用RkFieldConverter#bytes2entity方法使用字节数组设置DeviceInfo对象属性

{% codeblock lang:java %}
	byte[] bytes = new byte[]{82,75,52,49,48,48,0,68};
	DeviceInfo mDeviceInfo = new DeviceInfo();
	mDeviceInfo = RkFieldConverter.bytes2entity(mDeviceInfo,bytes);
	assertEquals("RK4100",mDeviceInfo.getModel());
	assertEquals(68,mDeviceInfo.getVersionCode());
{% endcodeblock %}

### 对象转字节数组
调用RkFieldConverter#entity2bytes方法将对象转换成字节数组方便将数据写入蓝牙设备。

{% codeblock lang:java %}
	DeviceInfo mDeviceInfo = new DeviceInfo();
	mDeviceInfo.setModel("RK4100");
	mDeviceInfo.setVersionCode(68);
	byte[] bytes = RkFieldConverter.entity2bytes(mDeviceInfo);
	assertArrayEquals(new byte[]{82,75,52,49,48,48,0,68},bytes);
{% endcodeblock %}
 
### [GitHub 项目地址][1]

[1]:	https://github.com/yuanzj/RkConverter

[image-1]:	http://7xs7jt.com1.z0.glb.clouddn.com/rkconvert1.png