package controllers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import play.mvc.Controller;
import util.ErrorNo;

public class BaseController extends Controller{
	private static final String RES_STATUS = "status";
	private static final String RES_ERR_MSG = "errmsg";
	private static final String RES_DATA = "data";
	
	protected static void checkParams(){
		if(validation.hasErrors()){
			Map<String, List<play.data.validation.Error>> errmap = validation.errorsMap();
			Iterator<String> it = errmap.keySet().iterator();
			String errors = "";
			while(it.hasNext()){
				String field = it.next();
				for(play.data.validation.Error err: errmap.get(field)){
					errors += field + ": " + err.message() + "\n";
				}
			}
			renderJSON(onError(ErrorNo.PARAM_LACK, errors));
		}
	}
	
	protected static Map<String, Object> onSuccess(Object retData){
		Map<String, Object> res = new HashMap<String, Object>();
		res.put(RES_STATUS, ErrorNo.OK);
		res.put(RES_ERR_MSG, "ok");
		res.put(RES_DATA, retData);
		return res;
	}
	
	protected static Map<String, Object> onError(int status, String msg){
		Map<String, Object> res = new HashMap<String, Object>();
		res.put(RES_STATUS, status);
		res.put(RES_ERR_MSG, msg);
		res.put(RES_DATA, null);
		return res;
	}
}
