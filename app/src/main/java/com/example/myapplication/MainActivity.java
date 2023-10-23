package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Thay thế "URL_API" bằng URL công cộng mà bạn đã nhận từ ngrok
        String apiUrl = "http://127.0.0.1:5000";  // URL công cộng của ứng dụng Flask trên Colab

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // Tạo một yêu cầu HTTP POST
        StringRequest request = new StringRequest(Request.Method.POST, apiUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Xử lý kết quả từ API
                        try {
                            JSONObject jsonResponse = new JSONObject(response);

                            // Trích xuất dữ liệu từ JSON response
                            String result = jsonResponse.getString("result");

                            // Xử lý kết quả ở đây (result là dữ liệu trả về từ API)
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Xử lý lỗi
                        error.printStackTrace();
                    }
                });

        // Thêm yêu cầu vào hàng đợi
        requestQueue.add(request);
    }
}
