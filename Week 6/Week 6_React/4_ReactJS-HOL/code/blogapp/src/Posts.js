import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: []
    };
  }

  loadPosts = async () => {
    const response = await fetch('https://jsonplaceholder.typicode.com/posts');
    const data= await response.json();
    const postsData =data.map(item => new Post(item.id, item.title, item.body));
    this.setState({posts: postsData});
  }

  componentDidMount() {this.loadPosts();}

  componentDidCatch(error, info) {
    alert("An error occurred pls check the component");
  }

  render() {
    return (
      <div>
        {this.state.posts.map(post => (
          <div key={post.id}>
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;