package com.frame.domain;

import lombok.Getter;

/**
 * @author zhanglm
 * @date 2018年11月23日 下午4:22:59
 * 
 */
public class Constants {

	/**
	 * 请求状态
	 * @author zhanglm
	 *
	 */
	public static enum reqstatus {
		SUCCESS("SUCCESS","成功"),
		FAILURE("FAILURE","失败");
		
		private reqstatus(String value,String name){
            this.value=value;
            this.name=name;
        }
        private final @Getter String value;
        private final @Getter String name;
	}
	
	
	
	/**
	 * 性别
	 * @author zhanglm
	 *
	 */
	
    public static enum sex{
        MAN("1","男"),FEMAN("2","女");
        private sex(String value,String name){
            this.value = value;
            this.name = name;
        }
        private final @Getter String value;
        private final @Getter String name;
    }
	
	
	
}
