import { Component, OnInit } from '@angular/core';
import {ConvertService} from './convert.service';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
@Component({
  selector: 'app-convert',
  templateUrl: './convert.component.html',
  styleUrls: ['./convert.component.css'],
  providers: [ConvertService],
})
export class ConvertComponent implements OnInit {

  constructor(private convertService: ConvertService) { }

  ngOnInit(): void {

  }

  isBase64: string = '';
  isShow = false;
  isShowImage = false;
  result: string = '';
  resultImageString: string = '';
  imageSrc: string = '';
  imageString: string = '';
  selectedFile!: File;


  //Submit Form Data
  onSubmit(formConvert: any) {
    switch (formConvert.value.convertType) {
      case 'stringtobase64':
        this.encodeString(formConvert);
        break;
      case 'base64tostring':
        this.decodeString(formConvert);
        break;
      case 'stringtohex':
        this.encodeString(formConvert);
        break;
      case 'hextostring':
        this.decodeString(formConvert);
        break;
      case 'stringtobyte':
        this.encodeString(formConvert);
        break;
      // case 'imagetobase64':
      //   this.encodeImage();
      //   break;
      // case 'base64toimage':
      //   this.getImage(formConvert);
      //   break;
    }
  }

  //Event Select Listener
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

  encodeString(formConvert: any) {
    this.convertService.sendPostStringEncode(formConvert.value).subscribe((response) => {
      this.result = JSON.stringify(response).replace(/^"(.*)"$/, '$1');
      console.log(this.result);
      console.log(response);
    });
  }


  decodeString(formConvert: any) {
    this.convertService.sendPostStringDecode(formConvert.value).subscribe((response) => {
      console.log(response);
      if(response =='invalid') {
        this.isBase64 = 'Base64 String Invalid';
      }else{
        this.result = JSON.stringify(response).replace(/^"(.*)"$/ , '$1');
        this.isBase64 = '';
      }
    });
  }
}
