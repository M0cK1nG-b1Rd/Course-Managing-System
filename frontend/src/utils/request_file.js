import axios from 'axios';
import store from '../store'

const service = axios.create({
  // axios中请求配置有baseURL选项，表示请求URL公共部分
  baseURL: `http://${process.env.BACKEND_API_HOST}/`,
  //超时时间
  timeout: 20000
});

//解决vue项目的浏览器兼容性问题
//带上token
service.interceptors.request.use((config) => {
    console.log("test")
    if (store.state.account.token) {
      config.headers.Authentication = store.state.account.token
    }
    return config;
  },
  error => {
    console.log(error);
    return Promise.reject();
  }
);

// 响应状态码是200则返回响应数据
service.interceptors.response.use(
  response => {
    if (response.status === 200) {
      return response.data;
    } else {
      Promise.reject();
    }
  },
  error => {
    console.log(error);
    return Promise.reject();
  }
);

export const requestApi = (option) => {
  if (option.isJson && JSON.stringify(option.data) !== {}) {
    return service({
      method: option.method,
      url: `${option.url}`,
      data: option.data,
      headers: {//向后台发送的数据必须为json字符串
        'Content-Type': 'application/json',
        'Authentication':store.state.account.token
      }
    })
  } else if (option.isJson && JSON.stringify(option.data) === {}) {
    return service({
      method: option.method,
      url: `${option.url}`,
      data: option.data,
      headers: {
        'Content-Type': 'application/json',
        'Authentication':store.state.account.token
      }
    })
  } else if (!option.isJson && JSON.stringify(option.data) !== {}) {
    return service({
      method: option.method,
      url: `${option.url}`,
      params: option.data,
      headers: {//请求信息格式，默认格式key1=value1,key2=value2
        'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8',
        'Authentication':store.state.account.token,
      },
      responseType: 'blob'
    })
  } else if (!option.isJson && JSON.stringify(option.data) === {}) {
    console.log(option);
    return service({
      method: option.method,
      url: `${option.url}`
    })
  }
}

