import axios, { AxiosResponse, Method }                   from "axios";
import { Dispatch, SetStateAction, useEffect, useState }  from "react";
import { urlServices } from "../types/Product";

//---- Constants ----
let baseUrl: urlServices;
//export const baseUrl = `http://localhost:8080/`;

type SetState<T> = Dispatch<SetStateAction<T>>;

// ---- Functions ---- 
/*
 * Custom Hook, combining useState and uesEffect, calling function api to communicate with
 * back-end
 * 
 * @param   url     [string]  : baseURL is set
 * @param   path    [string]  : relative path to baseUrl
 * @return, Response Data
 */
export function useApi<T>(url: urlServices, path: string): [T | undefined, SetState<T | undefined>] 
  {
    const [data, setData] = useState<T>();

    useEffect(() => {
      api("GET", url, path, setData);
    }, [path]);

    // console.log("data "+JSON.stringify(data))
    return [data, setData];
  }

/*
 * This useApi2 function was copied from useApi above and changed as follows:
 * - default state is an empty array[], so the map function in jsx is not stuck
 * - an if condition within the useEffect was added, which causes the useApi2 to 
 * wait till the condition arrives
 *
 * @param path      [string]  : relative path to baseUrl
 * @param condition [string]  : Api2 will wait till condition is fulfilled
 * @return, Response Data
 */
export function useApi2<T>(url: urlServices, path: string, condition: string)
: [T | undefined, SetState<T | undefined>]  {

const [data, setData] = useState<T>();

useEffect(() => {

console.log("condition: ",condition);

if(condition) api("GET", url, path, setData);
}, [condition]);

return [data, setData];
}

/*
 * Useful for calls on events or in conditions
 *
 * @param method      [Method]    : http method
 * @param path        [string]    : relative path to baseUrl
 * @param callback    [function]  : callback optionally
 * @param data        [object]    : body data
 * @return callback   [function]  : callback, gets `response.data` as an argument
 * 
 */
export function api<T>(
    method: Method,
    url: urlServices, 
    path: string,  
    callback?: any,
    data = {}): void {

        const config ={
            method,
            url: `${setBaseURL(url)}${path}`,
            data,
        } ;

        console.log('API config:',config);
        
        axios(config).then((response: AxiosResponse<T>) => {
          // console.log("response.data", response.data)  
          return callback(response.data);
        });
}

/**
 * Simplified Api for direct calling server and without callback function
 * 
 * @param   method  [Method]      : http method
 * @param   url     [string]      : baseURL is set
 * @param   path    [string]      : relative path to baseUrl
 * @param   data    [JSON]        : optionally data can be send with message
 * @return  axios   [AxiosPromise]: return message to be captured with .then
 */
export function apiSimplified<T>( method: Method, 
                                  url: urlServices,
                                  path: string, 
                                  data = {}) {

      const config ={
          method,
          url: `${setBaseURL(url)}${path}`,
          data,
      } ;

      console.log('API simple config: ', config);
      
      return axios(config)
      // .then((response: AxiosResponse<T>) => response.data);
      // .then((response: AxiosResponse<T>) => console.log('response.data: ', response.data));
}

// ---- Helper fubntions ----
/**
 * Function to assign url to selected service
 * 
 * @param url       [urlServices] : indicates which services is chosen
 * @return baseURL  [string]      : baseURL for chosen service
 */
const setBaseURL = (url: urlServices): string | undefined =>{

  // ---- variables ----
  let baseURL: string | undefined = "";

  switch (url){

    case "inventory": baseURL = process.env.REACT_APP_INVENTORY_URL;
      break;
    case "orders": baseURL = process.env.REACT_APP_ORDERS_URL;
      break;
    case "shipping": baseURL = process.env.REACT_APP_SHIPPING_URL;
      break;
    default: console.log("No such baseURL available")
  }

  return baseURL;
}