def project_url = "https://github.com/taoqidexiaomao/wzk.git"
def gitlab_auth = "0c4162d7-95a9-486d-9e34-636f469b338b"
def tag = "latest"
def harbor_url = "192.168.60.128:5000"
def harbor_project_name = "test"
def imageName = "${project_name}:${tag}"
def username="root"
def password="lijiaqi"
node {
    def mvnHome
    stage('拉取代码') { // 在流水线语法中选择checkout:Check out from version control，可得到此步骤脚本
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs:
        [[credentialsId: '0c4162d7-95a9-486d-9e34-636f469b338b', url: 'https://github.com/taoqidexiaomao/wzk.git']]])
    }
    stage('打包') {
       //编译，构建本地镜像;这个步骤要导入镜像包
       sh "mvn -f /home/jenkins_home/workspace/${project_name} clean package"
       sh "docker build -t ${imageName} /home/jenkins_home/workspace/${project_name}/."
       //给镜像打标签
       sh "docker tag ${imageName} ${harbor_url}/${harbor_project_name}/${imageName}"
    }
    stage('上传镜像') {
    withCredentials([usernamePassword(credentialsId: '4e1441ba-0cd4-4e3d-91f0-d77a058a5c55', passwordVariable: 'lijiaqi', usernameVariable: 'root')]) {                    //登录
                        sh "docker login -u ${username} -p ${password} ${harbor_url}"
                        //上传镜像
                        sh "docker push ${harbor_url}/${harbor_project_name}/${imageName}"
                        sh "echo 镜像上传成功"
        }
    }
    stage('执行') {
        //找到流水线语法sshPublisher:send bulid artifacts over ssh，其它的不管；execCommand中为deployy.sh脚本路径
        sshPublisher(publishers: [sshPublisherDesc(configName: 'contos7', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '/home/jenkins_home/workspace/deploy.sh', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
        }
}