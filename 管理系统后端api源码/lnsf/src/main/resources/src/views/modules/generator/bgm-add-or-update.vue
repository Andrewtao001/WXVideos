<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="配乐的作者" prop="author">
      <el-input v-model="dataForm.author" placeholder="配乐的作者"></el-input>
    </el-form-item>
    <el-form-item label="配乐名字" prop="name">
      <el-input v-model="dataForm.name" placeholder="配乐名字"></el-input>
    </el-form-item>
    <el-form-item label="配乐的路径" prop="path">
      <el-input v-model="dataForm.path" placeholder="配乐的路径"></el-input>
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
          author: '',
          name: '',
          path: ''
        },
        dataRule: {
          author: [
            { required: true, message: '配乐的作者不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '配乐名字不能为空', trigger: 'blur' }
          ],
          path: [
            { required: true, message: '配乐的路径不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/generator/bgm/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.author = data.bgm.author
                this.dataForm.name = data.bgm.name
                this.dataForm.path = data.bgm.path
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
              url: this.$http.adornUrl(`/generator/bgm/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'author': this.dataForm.author,
                'name': this.dataForm.name,
                'path': this.dataForm.path
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
