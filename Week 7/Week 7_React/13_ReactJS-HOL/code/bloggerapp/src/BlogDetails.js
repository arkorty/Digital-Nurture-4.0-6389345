import React from 'react';
import { blogs } from './data';

function BlogDetails() {
  const blogdet = (
    <ul>
      {blogs.map((blog) =>
        <div key={blog.id}>
          <h3>{blog.title}</h3>
          <h4>{blog.author}</h4>
          <p>{blog.content}</p>
        </div>
      )}
    </ul>
  );

  return (
    <div className="st2">
      <h1>Blog Details</h1>
      {blogdet}
    </div>
  );
}

export default BlogDetails;