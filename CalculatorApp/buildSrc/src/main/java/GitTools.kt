fun getGitCommitCount(): Int = "git rev-list HEAD --count".runCommand().toInt()
