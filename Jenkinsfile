
pipeline {
//    agent any
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
//                sh 'mvn -B -DskipTests clean package'
                sh 'ls -l /root/.m2/settings-docker.xml'
                sh 'echo $MAVEN_HOME'
                sh 'ls -l /usr/share/maven/ref/'
                sh 'cat /root/.m2/settings-docker.xml'
                sh 'cat /usr/share/maven/ref/settings-docker.xml'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
