import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable, Type } from '@angular/core';
import { environment } from "../../environments/environment";



@Injectable({
  providedIn: 'root'
})
export class ConvertservicesService {

  constructor (private httpClient: HttpClient){

  }

  ///Post convert
  convert(value: any, collaborate:any){
    return this.httpClient.post(environment.apiUrl + "/convert" + collaborate, value);
  }

  //gọi toàn bộ dữ liệu
  getList(){
    return this.httpClient.get(environment.apiUrl + "/convert/listconvert");
  }

}
