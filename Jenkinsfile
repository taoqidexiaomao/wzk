def project_url = "https://github.com/taoqidexiaomao/wzk.git"
def gitlab_auth = "0c4162d7-95a9-486d-9e34-636f469b338b"
def tag = "latest"
def harbor_url = "180.76.112.7:5000"
def harbor_project_name = "test"
def imageName = "${project_name}:${tag}"
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
    withCredentials([sshUserPrivateKey(credentialsId: '0c4162d7-95a9-486d-9e34-636f469b338b', keyFileVariable: 'ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCse1vwvc/oWjs8TvUvm+HqDv6lGmCmoTc9T4+5+2FR+qvsZ/5YIOVGZCl6gGNzatDakVwjIEzvCH7xQJSnrRIOe0REhizWfDi4QDVlVcOewjXYuCoecDGlvx4wGkEYqF6g45lNjOclAMwAVLZRLUA1u2JBIrdvSxsMFhn8s9KBtSGcECqTqfg9EAeYfA2a14swl80VsBbeKRKvXY+209hWtu4C6CQo9jlfqavZ6+8/Yd/cfdS/yXfVZoTsz0jGNH6h8zBHI/HQ9mGMsA/hI09eSa9OG5FQcjHhX/5WG0eogX1G3qsJ6I2S2PraJEN95DjM83aFkeQi/l1Rtb3RxfiF hdynqu@163.com', passphraseVariable: 'lijiaqi@123', usernameVariable: 'root')]) {
                    //登录
                    sh "docker login -u ${username} -p ${password} ${harbor_url}"
                    //上传镜像
                  	sh "docker push ${harbor_url}/${harbor_project_name}/${imageName}"
                    sh "echo 镜像上传成功"
    }
    }
    stage('执行') {
        //找到流水线语法sshPublisher:send bulid artifacts over ssh，其它的不管；execCommand中为deployy.sh脚本路径
        sshPublisher(publishers: [sshPublisherDesc(configName: 'baidu', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '/home/jenkins_home/workspace/deploy.sh', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '/target', sourceFiles: 'target/*.jar')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
        }
}