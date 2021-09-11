
pipeline {
    agent any
    tools {
    maven 'Maven 3.3.3'
  }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
