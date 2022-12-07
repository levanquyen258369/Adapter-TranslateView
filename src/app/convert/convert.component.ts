import { Component, OnInit } from '@angular/core';
import { ConvertservicesService } from '../services/convertservices.service';
import {FormBuilder, FormGroup} from '@angular/forms';
@Component({
  selector: 'app-convert',
  templateUrl: './convert.component.html',
  styleUrls: ['./convert.component.css']
})
export class ConvertComponent implements OnInit {


  isBase64: string = '';
  isShow = false;
  isShowImage = false;
  result: string = "";
  resultImageString: string = '';
  imageSrc: string = '';
  imageString: string = '';
  selectedFile!: File;
  convertElement: any;
  data: string = '';

  constructor(
    private convertService: ConvertservicesService,
    ) { }

  ngOnInit(): void {
    this.listAll();

  }
  listAll(){
   this.convertService.getList().subscribe(res=>{
     this.convertElement = res;
     console.log(res);

   })
  }


  onSubmit(formConvert: any) {
    const from = formConvert.value.convertType;
    const to = formConvert.value.convertType2;
    const collaborate = `/${from}/${to}`;

    this.convert(collaborate, this.data);
  }

  private convert(collaborate: string, data: string) {
    this.convertService.convert(
      {data: data}, collaborate
    ).subscribe((res: any) => {
        this.result = res.result;
      }
    )
  }

  onSelectChange(event: any) {
    if (event === 'imagetobase64') {
      this.isShow = true;
    } else {
      this.isShow = false;
    }
    if(event === 'base64toimage'){
      this.isShowImage = true;
    }else{
      this.isShowImage = false;
    }
  }


  //Event File Change
  onFileChange(event: any) {
    //console.log(event);
    const reader = new FileReader();
    {
        this.imageSrc = event.target.result;
      }
      // reader.readAsDataURL();
    }

  }

