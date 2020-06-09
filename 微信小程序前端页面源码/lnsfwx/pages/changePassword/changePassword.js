const app = getApp()

Page({
  data: {

  },
  changePassword: function (e) {
    var that = this;
    var user = app.getGloalUserInfo();
    var formObject = e.detail.value;
    var userId = user.userId;
    var password = formObject.password;
    var password1 = formObject.password1;
    if ( password.length == 0 || password1.length == 0) {
      //弹窗
      wx.showToast({
        title: '所修改的密码不能为空',
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
    else if (password1 != password) {
      //弹窗
      wx.showToast({
        title: '两次密码输入不正确',
        icon: 'none',
        duration: 3000,
      })
    }
    else {

      wx.showLoading({
        title: '正在修改密码中~~请等待',
      })
      var serverUrl = app.serverUrl;
      wx.request({
        url: serverUrl + '/changePassword',
        method: "POST",
        data: {
          id: userId,
          password: password,
        },
        header: {
          'content-type': 'application/json' //默认值
        },
        success: function (res) {
          wx.hideLoading();
          console.log(res.data);
          var status = res.data.status;
          if (status == 200) {
            wx.showToast({
              title: '用户密码修改成功',
              icon: 'none',
              duration: 3000,
            })
            //app.userInfo =res.data.data;
           wx.removeStorageSync("userInfo");
            wx.navigateTo({
              url: '../userLogin/login',
            })
          } else if (status == 500) {
            wx.showToast({
              title: res.data.msg,
              icon: 'none',
              duration: 3000,
            })
          }
        }
      })
    }
  },
  goLoginPage: function () {
    wx.navigateTo({
      url: '../userLogin/login',
    })
  }


})