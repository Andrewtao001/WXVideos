const app = getApp()

Page({
  data: {
    videoObject : {},
    bgmList: [],
    serverUrl: ""
  },

  onLoad: function (params) {
    console.log(params);
    var that = this;
    that.setData({
      videoObject: params
    })
    //var user = app.userInfo;
    var user = app.getGloalUserInfo();
    var serverUrl = app.serverUrl;
    wx.showLoading({
      title: '正在连接请等待',
    });
    // 调用后端
    wx.request({
      url: serverUrl + '/userbgm/bgmlist',
      method: "POST",
      header: {
        'content-type': 'application/json', // 默认值

      },
      success: function (res) {
        console.log(res.data.data);
        wx.hideLoading();
        if (res.data.status == 200) {
          var bgmList = res.data.data;
          that.setData({
            bgmList: bgmList,
            serverUrl: serverUrl
          })
        } 
      }
    });



  },
 uploadContent :function(e){
    console.log(e);
    var that =this;
      var bgmId =e.detail.value.bgms;
    var desc = e.detail.value.desc;
    console.log(this);
    //获取短视频时间长度
   var tempDuration = that.data.videoObject.tempdruation;
   var tempHeight = that.data.videoObject.tempHeight;
   var tempWidth = that.data.videoObject.tempWidth;
   var tempVideoUrl = that.data.videoObject.tempVideoUrl;
   var tempPictureUrl = that.data.videoObject.tempPictureUrl;
   //上传视频
       wx.showLoading({
         title: '上传视频中',
       })
       var serverUrl = app.serverUrl;
       var userInfo =app.getGloalUserInfo();
   console.log(userInfo);
       wx.uploadFile({
         url: serverUrl + '/userVideo/upLoadVideos',
         formData: {
            userId : userInfo.id,
           bgmId : bgmId,
           videoSeconds: tempDuration,
           videoWidth : tempWidth,
           videoHeight: tempHeight,
           desc : desc
         },
         filePath: tempVideoUrl,
         name: 'video',
         header: {
           'content-type': 'application/json', // 默认值
           'userId': userInfo.id,
           'uniqueKey': userInfo.userKey,
         },
         success: function (res) {
           const data = JSON.parse(res.data);
           console.log(data);
           //do something
           wx.hideLoading();
           if (data.status == 200) {
             wx.showToast({
               title: '视频上传成功',
               icon: 'success',
           })
           wx.redirectTo({
             url: '../mine/mine',
           })

           } else if (data.status == 502) {
             wx.showToast({
               title: res.data.msg,
               duration: 3000,
               icon: "none",
               success: function () {
                 wx.redirectTo({
                   url: '../userLogin/login',
                 })
               }
             })
           }
           else if (data.status == 500) {
             wx.showToast({
               title: res.data.msg,
             })
           }

         }
       })
     }

})
