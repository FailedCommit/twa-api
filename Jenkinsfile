
pipeline {
    tools {
    maven 'Maven 3.6.0'
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
