/**
 *
 */
package com.king.asynctask;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.king.entity.Person;
import com.king.utils.HttpUtils;


/**
 *  自定义下载json数据异步任务类
 */
public class DownloadJsonDataAysncTask extends AsyncTask<String, Void, Person> {
	private ProgressDialog dialog;
	private JsonDataSettingCallBack callBack;

	public DownloadJsonDataAysncTask(JsonDataSettingCallBack callBack, ProgressDialog dialog) {
		super();
		this.dialog = dialog;
		this.callBack = callBack;

	}

	@Override
	protected void onPreExecute() {
		dialog.setMessage("正在加载中。。。");
		dialog.show();
	}

	@Override
	protected Person doInBackground(String... params) {
		String jsonData = HttpUtils.getJsonData(params[0]);
		//String aboutur = UrlUtils.aboutur(params[0]);
		Person person = new Gson().fromJson(jsonData, Person.class);
		return person;
	}


	@Override
	protected void onPostExecute(Person result) {

		if (result != null) {
			callBack.setJsonData(result);
			dialog.dismiss();
		}
	}

	// 设置json格式的数据回调接口
	public interface JsonDataSettingCallBack {
		void setJsonData(Person result);
	}

}
