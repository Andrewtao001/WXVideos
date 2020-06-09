const app = getApp()

Page({
  data: {
    totalPage: 1, //视频的页数
    pages: 1, //当前页
    videosList:[],//分页对象
    serverUrl: app.serverUrl,//图片展示
    screenWidth: 350,//屏幕宽度自适配
    searchContent: "",
  },

  onLoad: function (params) {
    var that = this;
    var screenWidth = wx.getSystemInfoSync().screenWidth;
    that.setData({
      screenWidth: screenWidth,
    });
    var searchContent = params.search;
    var isSaveRecord = params.isSaveRecord;
    if (isSaveRecord== null ||isSaveRecord ==''||isSaveRecord == undefined){
      isSaveRecord =0;
    }
    that.setData({
      searchContent: searchContent
    });
    //获取当前页数
    var pages = that.data.pages;
    that.getVideosList(pages, isSaveRecord);
    
  },
  getVideosList: function (pages, isSaveRecord){
    var that = this;
    var serverUrl = that.data.serverUrl;
    wx.showLoading({
      title: '加载视频中...',
    });
    wx.request({
      url: serverUrl + '/userVideo/showAllVideos?pages=' + pages + "&isSaveRecord=" + isSaveRecord,
      data:{
        videoDesc: that.data.searchContent
      },
      method: "POST",
      success: function (res) {
        console.log(res);
        wx.hideNavigationBarLoading();//隐藏加载动画
        wx.stopPullDownRefresh();
        wx.hideLoading();
        //第一页清空videosList
        if (pages == 1) {
          that.setData({
            videosList: []//分页对象
          });
        }
        console.log(res.data.data);
        var videosList = res.data.data.rows;
        var videosList2 = that.data.videosList;
        that.setData({
          videosList: videosList2.concat(videosList),
          pages: pages,
          totalPage: res.data.data.total,
          serverUrl: serverUrl
        })
      }
    })
  },
  showVideoInfo: function(e) {
   var that =this;
   console.log(e);
    var videosList =that.data.videosList; 
    var arrindex =e.target.dataset.arrindex;
  var videoInfo =  JSON.stringify(videosList[arrindex]);
  wx.redirectTo({
    url: '../videoinfo/videoinfo?videoInfo='+videoInfo,
  })
  },
  onReachBottom:function(){
      var that =this;
      var currentPage = that.data.pages;
      var total       =that.data.totalPage;
      //  判断页数与总页数是否相等，是则不查询
    if (currentPage == total){
      wx.showToast({
        title: '已经没有新视频了~',
        icon: "none"
      })
       return;
    }
    var pages = currentPage+1;
    that.getVideosList(pages,0);
  },
  onPullDownRefresh:function(){
    wx.showNavigationBarLoading();//显示加载动画
    that.getVideosList(1,0);
  },



})
