const app = getApp()

Page({
    data: {
       question1: '',
        question2: ''       ,
       question3: '' 
    },
  onLoad: function (params) {
    var me = this;
    var user = app.getGloalUserInfo();
    var question1 = user.question1;
    var question2 = user.question2;
    var question3 = user.question3;
    me.setData({
      question1: question1,
      question2: question2,
      question3: question3, 
    })
  },
  doIdentity : function(e){
    var that =this;
    var user = app.getGloalUserInfo();
    var userId = user.userId;
      var formObject =e.detail.value;
    var question1 = formObject.question1;
      var answer1 =formObject.answer1;
    var question2 = formObject.question2;
    var answer2 = formObject.answer2;
    var question3 = formObject.question3;
    var answer3 = formObject.answer3;
    if (question1.length == 0 || question2.length == 0 || question3.length == 0 || answer1.length == 0 || answer2.length == 0 || answer3.length == 0) {
        //弹窗
        wx.showToast({
              title:'用户密保不能为空',
              icon:'none',
              duration:3000,
        })
    } else if (question1 == question2 || question1 == question3 || question2 == question3){
      //弹窗
      wx.showToast({
        title: '用户密保问题不能相同',
        icon: 'none',
        duration: 3000,
      })
    }
      else{
        wx.showLoading({
          title: '密保验证中~~',
        })
        var serverUrl = app.serverUrl;
        wx.request  ({
          url: serverUrl +'/IdentityPassword',
          method: "POST",
          data: {
            question1: question1,
            question2: question2,
            question3: question3,
            answer1: answer1,
            answer2: answer2,
            answer3: answer3,
            userId: userId
          },
          header: {
            'content-type' :'application/json' //默认值
          },
          success: function(res){
            wx.hideLoading();
              console.log(res.data);
            var status = res.data.status;
            console.log(status);
            if (status == 200){
                wx.showToast({
                  title: '用户密保核验成功',
                  icon: 'none',
                  duration: 3000,
                })
                //app.userInfo =res.data.data;
              wx.navigateTo({
                url: '../changePassword/changePassword',
              })
             //wx.removeStorageSync("userInfo");
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
        url: '../user/login',
      })
    }

   
})