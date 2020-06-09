<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="发布视频用户id" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="发布视频用户id"></el-input>
    </el-form-item>
    <el-form-item label="音频id" prop="audioId">
      <el-input v-model="dataForm.audioId" placeholder="音频id"></el-input>
    </el-form-item>
    <el-form-item label="用户输入的视频内容" prop="videoDesc">
      <el-input v-model="dataForm.videoDesc" placeholder="用户输入的视频内容"></el-input>
    </el-form-item>
    <el-form-item label="视频上传路径" prop="videoPath">
      <el-input v-model="dataForm.videoPath" placeholder="视频上传路径"></el-input>
    </el-form-item>
    <el-form-item label="视频播放秒数" prop="videoSeconds">
      <el-input v-model="dataForm.videoSeconds" placeholder="视频播放秒数"></el-input>
    </el-form-item>
    <el-form-item label="视频的宽" prop="videoWidth">
      <el-input v-model="dataForm.videoWidth" placeholder="视频的宽"></el-input>
    </el-form-item>
    <el-form-item label="视频的高" prop="videoHeight">
      <el-input v-model="dataForm.videoHeight" placeholder="视频的高"></el-input>
    </el-form-item>
    <el-form-item label="视频封面路径" prop="coverPath">
      <el-input v-model="dataForm.coverPath" placeholder="视频封面路径"></el-input>
    </el-form-item>
    <el-form-item label="视频获得喜欢的数量" prop="likeCounts">
      <el-input v-model="dataForm.likeCounts" placeholder="视频获得喜欢的数量"></el-input>
    </el-form-item>
    <el-form-item label="视频状态" prop="status">
      <el-input v-model="dataForm.status" placeholder="视频状态"></el-input>
    </el-form-item>
    <el-form-item label="视频发布日期" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="视频发布日期"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          userId: '',
          audioId: '',
          videoDesc: '',
          videoPath: '',
          videoSeconds: '',
          videoWidth: '',
          videoHeight: '',
          coverPath: '',
          likeCounts: '',
          status: '',
          createTime: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '发布视频用户id不能为空', trigger: 'blur' }
          ],
          audioId: [
            { required: true, message: '音频id不能为空', trigger: 'blur' }
          ],
          videoDesc: [
            { required: true, message: '用户输入的视频内容不能为空', trigger: 'blur' }
          ],
          videoPath: [
            { required: true, message: '视频上传路径不能为空', trigger: 'blur' }
          ],
          videoSeconds: [
            { required: true, message: '视频播放秒数不能为空', trigger: 'blur' }
          ],
          videoWidth: [
            { required: true, message: '视频的宽不能为空', trigger: 'blur' }
          ],
          videoHeight: [
            { required: true, message: '视频的高不能为空', trigger: 'blur' }
          ],
          coverPath: [
            { required: true, message: '视频封面路径不能为空', trigger: 'blur' }
          ],
          likeCounts: [
            { required: true, message: '视频获得喜欢的数量不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '视频状态不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '视频发布日期不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/generator/videos/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.videos.userId
                this.dataForm.audioId = data.videos.audioId
                this.dataForm.videoDesc = data.videos.videoDesc
                this.dataForm.videoPath = data.videos.videoPath
                this.dataForm.videoSeconds = data.videos.videoSeconds
                this.dataForm.videoWidth = data.videos.videoWidth
                this.dataForm.videoHeight = data.videos.videoHeight
                this.dataForm.coverPath = data.videos.coverPath
                this.dataForm.likeCounts = data.videos.likeCounts
                this.dataForm.status = data.videos.status
                this.dataForm.createTime = data.videos.createTime
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/generator/videos/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userId': this.dataForm.userId,
                'audioId': this.dataForm.audioId,
                'videoDesc': this.dataForm.videoDesc,
                'videoPath': this.dataForm.videoPath,
                'videoSeconds': this.dataForm.videoSeconds,
                'videoWidth': this.dataForm.videoWidth,
                'videoHeight': this.dataForm.videoHeight,
                'coverPath': this.dataForm.coverPath,
                'likeCounts': this.dataForm.likeCounts,
                'status': this.dataForm.status,
                'createTime': this.dataForm.createTime
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
