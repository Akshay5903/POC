rm -rf C:/Users/Administrator/pmdClasses
rm -rf C:/Windows/System32/config/systemprofile/AppData/Local/Jenkins/.jenkins/workspace/CICDPullRequestValidator/package
rm -rf C:/Windows/System32/config/systemprofile/AppData/Local/Jenkins/.jenkins/workspace/CICDPullRequestValidator/convert
rm -rf C:/Windows/System32/config/systemprofile/AppData/Local/Jenkins/.jenkins/workspace/CICDPullRequestValidator/destructiveChanges
mkdir -p C:/Users/Administrator/pmdClasses
git diff --name-only origin/main..HEAD > commitResultDiff.txt
git show -s --format='%ae' HEAD > pullRequestInitiatorEmail.txt