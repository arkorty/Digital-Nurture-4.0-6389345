import React from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';
import './App.css';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      showBooks: true,
      showBlogs: true,
      showCourses: true,
    };
    this.toggleBooks = this.toggleBooks.bind(this);
    this.toggleBlogs = this.toggleBlogs.bind(this);
    this.toggleCourses = this.toggleCourses.bind(this);
  }

  toggleBooks() {
    this.setState(prevState => ({
      showBooks: !prevState.showBooks
    }));
  }

  toggleBlogs() {
    this.setState(prevState => ({
      showBlogs: !prevState.showBlogs
    }));
  }

  toggleCourses() {
    this.setState(prevState => ({
      showCourses: !prevState.showCourses
    }));
  }

  render() {
    const { showBooks, showBlogs, showCourses } = this.state;
    return (
      <div className="App">
        <h1>Blogger App</h1>
        <div className="controls">
          <button onClick={this.toggleCourses}>
            {showCourses ? 'Hide Course Details' : 'Show Course Details'}
          </button>
          <button onClick={this.toggleBooks}>
            {showBooks ? 'Hide Book Details' : 'Show Book Details'}
          </button>
          <button onClick={this.toggleBlogs}>
            {showBlogs ? 'Hide Blog Details' : 'Show Blog Details'}
          </button>
        </div>
        <div className="App-header">
          {showCourses && <CourseDetails />}
          {showCourses && showBooks && <div className="v1"></div>}
          {showBooks && <BookDetails />}
          {showBlogs && showBooks && <div className="v1"></div>}
          {showBlogs && <BlogDetails />}
        </div>
      </div>
    );
  }
}

export default App;