// import logo from './logo.svg';
import './App.css';
import React from 'react';
import Login from './login';
import { isLogin, logout } from './helper';
import { login } from './helper';
import FileUpload from './fileUpload';

export default  class App extends React.Component{
  state = {
    isLogin: isLogin(),
    jsonData: []
  }

  onSubmitLogin = (data) => {
    const {userName, password} = data;
    login(userName, password);
    this.setState({
      isLogin: isLogin()
    })
    this.fetchJsonData();
  }

  onLogout = () => {
    logout();
    this.setState({
      isLogin: isLogin()
    })
  }
  componentDidMount(){
    if(this.state.isLogin) {
      this.fetchJsonData();
    }
  }

  fetchJsonData = () => {
    fetch(`http://localhost:8990/getData`).then(res => res.json()).then(data => {
      this.setState({
        jsonData: data || []
      })
    })
  }


  onChangeFile = (e) => {
    const file = e.target.files[0];
    const formData = new FormData();
    formData.append(`file`, file);
    
    fetch('http://localhost:8990/upload',{
      method:'post',
      body:formData
    }).then(res => res.json()).then(data => {
      this.setState({
        jsonData : data || []
      })
    })
  }

  render(){
    return(
      <div>
        {!this.state.isLogin && <Login onSubmitLogin={this.onSubmitLogin} />}
        {this.state.isLogin && <FileUpload onLogout={this.onLogout} onChangeFile={this.onChangeFile} jsonData={this.state.jsonData} />}
      </div>
    );
  }
}


