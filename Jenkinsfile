pipeline {
    agent any
    stages {
        stage ('Test') {
            steps {
                sh 'mvn clean package -DskipTests=true'
            }
        }
    }
}