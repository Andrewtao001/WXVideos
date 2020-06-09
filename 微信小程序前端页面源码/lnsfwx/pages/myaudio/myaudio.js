// pages/myaudio/myaudio.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    src: String,
    name: String,
    author: String,
    duration: String
  },

  /**
   * 组件的初始数据
   */
  data: {
      music :{},
      isPlaying : false,
      ico : "play",
  },

  ready(){
    var music =wx.createInnerAudioContext();
    music.src =this.data.src;
    this.setData({
      music : music
    })
  },
  /**
   * 组件的方法列表
   */
  methods: {
  statuss(){
    console.log(this.data)
    var isPlaying = this.data.isPlaying;
    if(!isPlaying){
      this.data.music.play();
      this.setData({
        isPlaying : true,
          ico : "pause"
      })
    } else {
      this.data.music.pause();
      this.setData({
        isPlaying: false,
        ico: "play"
      })
    }
  }
  }
})
