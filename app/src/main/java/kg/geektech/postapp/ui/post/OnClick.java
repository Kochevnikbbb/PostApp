package kg.geektech.postapp.ui.post;

import kg.geektech.postapp.data.models.Post;

public interface OnClick {
    void onClick(Post post);
    void onLongClick(Post post);
}
