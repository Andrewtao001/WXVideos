const app = getApp()

Page({
  data: {
  },

 

  // 登录  
  findIdentity: function (e) {
    wx.removeStorageSync("userInfo");
    var me = this;
    var formObject = e.detail.value;
    var username = formObject.username;
    // 简单验证
    if (username.length == 0) {
      wx.showToast({
        title: '忘记密码的账号不能为空',
        icon: 'none',
        duration: 3000
      })
    } else {
      var serverUrl = app.serverUrl;
      wx.showLoading({
        title: '请等待...',
      });
      // 调用后端
      wx.request({
        url: serverUrl + '/findIdentity?username='+username,
        method: "POST",
        header: {
          'content-type': 'application/json' // 默认值
        },
        success: function (res) {
          console.log(res.data);
          wx.hideLoading();
          if (res.data.status == 200) {
            // 登录成功跳转 
            wx.showToast({
              title: '账号查询成功',
              icon: 'success',
              duration: 2000
            });
            // app.userInfo = res.data.data;
            app.setGloalUserInfo(res.data.data);
            // fixme 修改原有的全局对象为本地缓存
           // app.setGlobalUserInfo(res.data.data);
            // 页面跳转
          wx.redirectTo({
            url: '../identityPassword/identityPassword',
          })
            
          } 
          else if (res.data.status == 500) {
            // 失败弹出框
            wx.showToast({
              title: res.data.msg,
              icon: 'none',
              duration: 3000
            })
          }
        }
      })
    }
  },

  goLogin:function() {
    wx.redirectTo({
      url: '../userLogin/login',
    })
  },
  goPasswordPage: function () {
    wx.redirectTo({
      url: '../userRegist/regist',
    })
  }
})