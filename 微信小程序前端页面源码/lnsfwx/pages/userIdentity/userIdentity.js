const app = getApp()

Page({
    data: {
      onUpLoad: false
    },
  //添加上传图片
  chooseImageTap: function () {
    var that = this;
    wx.showActionSheet({
      itemList: ['从相册中选择', '拍照'],
      itemColor: "#00000",
      success: function (res) {
        if (!res.cancel) {
          if (res.tapIndex == 0) {
            that.chooseWxImage('album')
          } else if (res.tapIndex == 1) {
            that.chooseWxImage('camera')
          }
        }
      }
    })
  },
  // 图片本地路径
  chooseWxImage: function (type) {
    var that = this;
    wx.chooseImage({
      sizeType: ['original', 'compressed'],
      sourceType: [type],
      success: function (res) {
        console.log(res.tempFilePaths[0]);
        that.upImgs(res.tempFilePaths[0], 0) //调用上传方法
      }
    })
  },
  //上传服务器
  upImgs: function (imgurl, index) {
    var serverUrl = app.serverUrl;
    var user = app.getGloalUserInfo();
    var userId = user.id;
    var that = this;
    wx.uploadFile({
      url: serverUrl + '/uploadUserFaces?userId=' + user.id,
      name: 'file',
      filePath: imgurl,
      header: {
        'content-type': 'application/json', // 默认值
        'userId': user.id,
        'uniqueKey': user.userKey,
      },
      formData: null,
      success: function (res) {
        that.setData({
          onUpLoad: true,
        })
      }
    })
  },
  doIdentity: function(e){
    var that =this;
    var user = app.getGloalUserInfo();
    var userId = user.id;
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
     else if (that.data.onUpLoad == false) {
        //弹窗
        wx.showToast({
          title: '请上传学生证首页',
          icon: 'none',
          duration: 3000,
        })
      }
      else{
        wx.showLoading({
          title: '密保输入中~~请等待',
        })
        var serverUrl = app.serverUrl;
        wx.request  ({
          url: serverUrl +'/userIdentity',
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
                  title: '用户密保输入成功',
                  icon: 'none',
                  duration: 3000,
                })
                //app.userInfo =res.data.data;
              wx.showToast({
                title: '正在等待管理员审核学生账号~~~',
                icon: 'none',
                duration: 5000,
              })
              wx.navigateTo({
                url: '../userLogin/login',
              }),
        
              wx.removeStorageSync("userInfo");
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