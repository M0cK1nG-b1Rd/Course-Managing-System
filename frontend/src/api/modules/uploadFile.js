import {requestApi} from '@/utils/request_file';
import { option } from '@/api/optionParam';

export const mergeFile = data => {
    option.isJson = true
    option.data = JSON.stringify(data)
    option.method = 'post'
    option.url = '/uploader/mergeFile'
    return requestApi(option)
}

export const selectFileList = query => {
    option.isJson = true
    option.data = query
    option.method = 'get'
    option.url = '/uploader/selectFileList'
    return requestApi(option)
};

export const deleteFile = data => {
    option.isJson = true
    option.data = JSON.stringify(data)
    option.method = 'post'
    option.url = '/uploader/deleteFile'
    return requestApi(option)
}

export const downloadFile = row => {
  option.isJson = false
  option.data = {}
  option.method = 'get'
  option.url = '/uploader/download?id='+row.id+'&filename='+row.filename+'&location='+row.location
  return requestApi(option)
};
