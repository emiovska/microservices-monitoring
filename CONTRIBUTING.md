### Git workflow
Always make a new branch of the up to date master branch for each issue you working on. 
The conventional way to name your branch is to put the issue number before the name of the branch.
The words in the branch name should be separated using the **dash sign(-)**.
For example, if you work on issue #issueNumber, the branch should be **#issueNumber-my-branch**.
  
Never work on master branch! If you accidentaly work on it, stash you changes and move to another branch.
  
Never work on more than one issue in the same branch. Reject the pull request if you see it happens. 
Exception from this rule is when you are fixing two or more related defects.
  
When working on one issue, it might take a day or two to finish. To keep track of your progress, always reference the issue in the commit message.
   
When you are done with the implementaion details required by the issue do not make a pull request right away. 
Look through the changes you made and make a self review. When you feel ready create a pull request. 
Wait for any changes request from code reviewers. After you get at least two green signal, take a look to other pull request and make merge strategy, avoid merging the same things twice. 
When you decide to merge the pull request, merge it and delete the branch. 

### Pull request format
Pull requests let you tell others about changes you've pushed to a repository on GitHub. When creating a pull request, remember that the **base branch is where changes should be applied, the head branch contains what you would like to be applied**. By default, pull requests are based on the parent repository's default branch which actually is the production branch so be careful to change the base branch to be the development branch. The name of the pull request should containt the issue number and short name. Most of the time the name of the pull request should be the name of branch without the desh sign(-). If you have some additional info that you want to share with the code reviewers please write down a description.
  
  
### Commit message
1. Always write a comment when committing something to the repository. Avoid the messages of the type: fixes, merges, no comment etc
2. The comment should be brief and to the point
3. The comment should be in past simple tense
4. If you made several changes, separate the changes in different sentances.
5. Always prefixing your comment with issue number wrapped in square brackets ([#issueNumber]). If there is not an issue, prefix the comment with [no-issue]. For example [#issueNumber]-Implemented commit message guideline. Square brackets are good approach because some IDEs threat the hash sign(#) as a comment sign when is a leading character of a commit message
 
### Code review
Code reviewing is very important! You need to make sure that you're fully understand about the changes were made. 
Check for error, insufficient code, code styling and make appropriate change requests. 

When you are requesting some changes always provide a reason why the changes should be made, it is a good practise of knowledge sharing.

### Protect master(producation) branch
If the repository has multiple collaborators, we should protect the producation branch from irrevocable changes.
Protected branches block several features of Git on a branch that a repository administrator chooses to protect. A protected branch:
- Can't be force pushed
- Can't be deleted
- Can't have changes merged into it until required status checks pass
- Can't have changes merged into it until required reviews are approved
- Can't be edited or have files uploaded to it from the web
