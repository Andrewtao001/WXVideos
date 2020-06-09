const app = getApp()

Page({
    data: {
    
    },
    doRegist: function(e){
      var that =this;
      var formObject =e.detail.value;
      var username =formObject.username;
      var password =formObject.password;
      var password1 = formObject.password1;
      if (username.length == 0 || password.length == 0 || password1.length ==0){
        //弹窗
        wx.showToast({
              title:'用户名或密码不能为空',
              icon:'none',
              duration:3000,
        })
      } else if (username.length > 15) {
        wx.showToast({
          title: '用户名最大为不能超过15位',
          icon: 'none',
          duration: 3000,
        })
      }
      else if (username.length < 6) {
        wx.showToast({
          title: '用户名最小不能小于6位',
          icon: 'none',
          duration: 3000,
        })
      } 
      else if (password.length > 15) {
        wx.showToast({
          title: '密码最大为不能超过15位',
          icon: 'none',
          duration: 3000,
        })
      }
      else if (password.length < 6) {
        wx.showToast({
          title: '密码最小不能小于6位',
          icon: 'none',
          duration: 3000,
        })
      } 
      else if (password1 != password){
        //弹窗
        wx.showToast({
          title: '两次密码输入不正确',
          icon: 'none',
          duration: 3000,
        })
      } 
      else{
      
        wx.showLoading({
          title: '正在注册中~~请等待',
        })
        var serverUrl = app.serverUrl;
        wx.request  ({
          url: serverUrl +'/regist',
          method: "POST",
          data: {
            username : username,
            password: password,
          },
          header: {
            'content-type' :'application/json' //默认值
          },
          success: function(res){
            wx.hideLoading();
              console.log(res.data);
            var status = res.data.status;
            if (status == 200){
                wx.showToast({
                  title: '用户注册成功,请输入账号密保',
                  icon: 'none',
                  duration: 3000,
                })
                //app.userInfo =res.data.data;
              app.setGloalUserInfo(res.data.data);
              wx.navigateTo({
                url: '../userIdentity/userIdentity',
              })
            } else if (status == 500){
                wx.showToast({
                  title: res.data.msg ,
                  icon: 'none',
                  duration: 3000,
                })
              }
          }
        })
      }
    },
    goLoginPage:function(){
      wx.navigateTo({
        url: '../userLogin/login',
      })
    }

   
})