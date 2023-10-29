* {
    margin: 0px;
    padding: 0px;
}

.line-header{
    top:0;
    left: 0;
    height: 50px;
    width: 100vw;
    background-color:#253749;
    color:white;
    display: table-cell;
    text-align: center;
    vertical-align: middle;
}
.line-container{
    background-color:#49F;
    height: calc(100% - 100px);
    overflow: scroll;
}


.line-form{
    bottom: 0;
    left: 0;
    height: 50px;
    background-color: #eee;
    display:flex;
}

.line-form-button{
  color: #FFF;
  background: #03A9F4;/*êF*/
  border: solid 1px #039fAA;/*ê¸êF*/
  border-radius: 5px;
  margin:8px;
  padding:1px 5px;
}

input{
    width: 80%;
    border-radius:5px;
    margin:8px 5px;
}
.line-right{
    position: relative;
    margin-right: 5%;
    float: right;
    display: block;
    max-width: 75%;
    margin: 5px 30px;
    clear: both;
}
.line-right::after{
    content: "";
    position: absolute;
    top: 3px; 
    right: -19px;
    border: 8px solid transparent;
    border-left: 18px solid #3c3;
    -webkit-transform: rotate(-35deg);
    transform: rotate(-35deg);
}
.line-right .line-right-text{
    background: #3c3;
    border-radius: 10px;
    padding:0.5em 1em ;
    word-break: break-all;
}

.line-right-time{
    color: white;
    size:0.2em;
    float: left;
}

.line-left{
  position: relative;
  padding: 10px;
  float: left;
    display: flex;
    margin: 2px 0;
    max-width: 75%;
    clear: both;
}

.line-left-container{
    margin-left:15px; 
    overflow: hidden;
}

.line-left .line-left-text{
    background: #eee;
    border-radius: 10px;
    padding:0.5em 1em ;
    word-break: break-all;
}
.line-left .line-left-text::after{
  content: "";
  display: block;
  position: absolute;
  top: 30px; 
  left: 50px;
  border: 8px solid transparent;
  border-right: 18px solid #edf1ee;
  -webkit-transform: rotate(35deg);
  transform: rotate(35deg);
}

.line-left-time{
    color: white;
    size:0.2em;
    float: right;
}

.line-left-name{
    color: white;
}

.line-left img{
    border-radius: 50%;
    width: 40px;
    height: 40px;
    border: #333;
    background-color: #eee;
}

@media screen and (max-width:600px){
    .line{
        height: 100%;
    }
}
@media screen and (min-width:601px){
    .line {
        height: 500px;
        width: 300px;
        margin: calc((100vh - 500px)/2) auto;
        border: solid 30px  #aaa;
        border-radius: 1em;
    }
}
