package com.org.api;

/**
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServiceRelated {

    private CookieStore httpCookieStore = new BasicCookieStore();
    private HttpClient client = HttpClientBuilder.create().setDefaultCookieStore(httpCookieStore).useSystemProperties().build();
    private StringBuffer postResponse;
    private int responseCode;
    private HashMap<String,String> headerDetails = new HashMap<String, String>();
    private List<NameValuePair> paramList = new ArrayList<NameValuePair>();

    /**
     * Creater : Sitangshu Pal
     * Date: 11-January-2018
     *
     * @param url
     */
    public void sendPost(String url) {
        HttpPost post = new HttpPost(url);

        for(String key : headerDetails.keySet()){
            post.setHeader(key, headerDetails.get(key));
        }

        try {
            post.setEntity(new UrlEncodedFormEntity(paramList));
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }
        //Execute post method
        HttpResponse response = null;
        try {
            response = client.execute(post);
        } catch (IOException e) {
            System.out.println(e);
        }
        //get the status code
        responseCode = response.getStatusLine().getStatusCode();
        //prepare the response output
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        } catch (IOException e) {
            System.out.println(e);
        }
        StringBuffer result = new StringBuffer();
        String line = "";
        try {
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        postResponse = result;
    }

    /**
     * Creater : Sitangshu Pal
     * Date: 11-January-2018
     *
     * @param url
     * @return
     */
    public String GetPageContent(String url) {
        HttpGet request = new HttpGet(url);

        for(String key : headerDetails.keySet()){
            request.setHeader(key, headerDetails.get(key));
        }

        HttpResponse response = null;
        try {
            response = client.execute(request);
        } catch (IOException e) {
            System.out.println(e);
        }

        responseCode = response.getStatusLine().getStatusCode();
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        } catch (IOException e) {
            System.out.println(e);
        }

        StringBuffer result = new StringBuffer();
        String line = "";
        try {
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return result.toString();
    }

    /**
     * Creater : Sitangshu Pal
     * Date: 11-January-2018
     *
     * @return
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * Creater : Sitangshu Pal
     * Date: 11-January-2018
     * @param headerName
     * @param hostValue
     * @return
     */
    public ServiceRelated setHeader(String headerName,String hostValue) {
        headerDetails.put(headerName,hostValue);
        return this;
    }

    /**
     * Creater : Sitangshu Pal
     * Date: 11-January-2018
     * @param paramName
     * @param paramValue
     * @return
     */
    public ServiceRelated setParamList(String paramName, String paramValue){
        paramList.add(new BasicNameValuePair(paramName, paramValue));
        return this;
    }

    /**
     * Creater : Sitangshu Pal
     * Date: 11-January-2018
     * @return
     */
    public ServiceRelated setUseSystemProperties(){
        client = HttpClientBuilder.create().setDefaultCookieStore(httpCookieStore).useSystemProperties().build();
        return this;
    }

    /**
     * Creater : Sitangshu Pal
     * Date: 11-January-2018
     * @return
     */
    public ServiceRelated setDefaultCookieStore(){
        client = HttpClientBuilder.create().setDefaultCookieStore(httpCookieStore).build();
        return this;
    }

}