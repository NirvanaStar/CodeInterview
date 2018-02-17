public TreeNode ConvertToDoublelist(TreeNode root){
        if (root == null){
            return root;
        }

        if (root.left != null){
            TreeNode left = ConvertToDoublelist(root.left);

            for (left.right != null){
                left = left.right;
            }

            left.right = root;
            root.left = left;
        }

        if (root.right != null){
            TreeNode right = ConvertToDoublelist(root.right);

            for (right.left != null){
                right = right.left;
            }

            right.left = root;
            root.right = right;
        }
        
        return root;
    }
