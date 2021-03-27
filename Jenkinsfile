pipeline {
    agent any
    stages {
        stage ('Build Backend') {
            steps {
                sh 'mvn clean package -DskipTests=true'
            }
        }
        stage ('Unit Tests') {
            steps {
                sh 'mvn test'
            }
        }
        stage ('Sonar Analysis') {
            environment {
                scannerHome = tool 'sonar_scanner'
            }
            steps {
                withSonarQubeEnv('sonar_local') {
                    sh "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=DeployBack -Dsonar.host.url=http://localhost:9000 -Dsonar.login=448fd16764355549494ce81177486b2dd23b2dd7 -Dsonar.java.binaries=target -Dsonar.coverage.exclusions=**/model/**,**Application.java"
                }
            }
        }
//         stage ('Quality Gate') {
//             steps {
//                 sleep(5)
//                 timeout(time: 1, unit: 'MINUTES') {
//                     waitForQualityGate abortPipeline: true
//                 }
//             }
//         }
        stage ('Deploy Backend') {
            steps {
                deploy adapters: [tomcat8(credentialsId: 'login_tomcat', path: '', url: 'http://localhost:8001/')], contextPath: 'tasks-backend', war: 'target/tasks-backend.war'
            }
        }
        stage ('API Test') {
            steps {
                dir('api-test') {
                    git branch: 'main', credentialsId: 'login_github', url: 'https://github.com/paulojp-dev/tasks-api-test'
                    sh 'mvn test'
                }
            }
        }
    }
}

