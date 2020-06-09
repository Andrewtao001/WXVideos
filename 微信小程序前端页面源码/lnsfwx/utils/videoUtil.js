function uploadVideo() {
  var that = this;
  wx.chooseVideo({
    sourceType: ['album'],
    success(res) {
      //获取短视频时间长度
      var tempDuration = res.duration;
      var tempHeight = res.height;
      var tempWidth = res.width;
      var tempVideoUrl = res.tempFilePath;
      var tempPictureUrl = res.thumbTempFilePath;


      if (tempDuration > 31) {
        wx.showToast({
          title: '视频长度不能超过30秒...',
          icon: "none",
          tempDuration: 2500
        })
      } else if (tempDuration < 3) {
        wx.showToast({
          title: '视频长度不能短于3秒...',
          icon: "none",
          tempDuration: 2500
        })
      } else {
        //打开选择bgm的目录
        wx.navigateTo({
          url: '/pages/chooseBgm/chooseBgm?tempdruation=' + tempDuration +
            "&tempHeight=" + tempHeight +
            "&tempVideoUrl=" + tempVideoUrl +
            "&tempPictureUrl=" + tempPictureUrl +
            "&tempWidth=" + tempWidth,
        })
      }
    }
  })
}
module.exports = {
  uploadVideo: uploadVideo
}