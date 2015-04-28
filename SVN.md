#useful informations about svn

# Introduction #

On this page, you can read/add informations about svn.
Your experiences, problems and solutions and/or hints.

# Problems when creating a java file #

If you receive an error in eclipse, that you current working project isn't a java project you checked out the wrong folder.
The easiest way is, to check out the Rembrand folder all the time and use the "Check out as..." option to give your working project a name.

# Check out multiple branches in Eclipse #

If you have multiple branches you want to working on, you could get problems if you only check out the Rembrand folder.
You could use "Check out as..." to change the project name and to check out multiple branches.

# Merge with stable #

To get the latest revision of the current project into your branch you need only to merge it with the trunk location.
Follow these steps:
  1. Update your branch with the update function and take sure that you've committed all changes.
  1. Choose Team-->Merge
  1. Choose the view with one URL
  1. Select the /svn/trunk/Rembrandt URL
  1. You can use the preview button to take a look what will happen
    * If your merge fails, delete the project folder and make a new check out from the repository
  1. Press the OK button to merge
  1. If there are any problems with the merge it should now be displayed
  1. Use the right mouse button to "edit conflicts"
  1. If you finished it, use the "mark as merged" function in the dialog menu when using the right mouse button again.
  1. You're done when no more conflics are displayed.