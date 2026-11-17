import { useEffect, useState } from "react";
import api from "./api";
import AuthForm from "./AuthForm";
import PostForm from "./PostForm";

const App = () => {
  const [user, setUser] = useState(() =>
    localStorage.getItem("token") && localStorage.getItem("username")
      ? localStorage.getItem("username")
      : null,
  );
  const [posts, setPosts] = useState([]);
  const [postsError, setPostsError] = useState("");

  const loadPosts = async () => {
    try {
      const { data } = await api.get("/posts");
      setPosts(data);
      setPostsError("");
    } catch {
      setPostsError("We couldn't load the posts. Please refresh and try again.");
    }
  };
  useEffect(() => {
    let active = true;
    api.get("/posts")
      .then(({ data }) => {
        if (active) {
          setPosts(data);
          setPostsError("");
        }
      })
      .catch(() => {
        if (active) {
          setPostsError("We couldn't load the posts. Please refresh and try again.");
        }
      });

    return () => {
      active = false;
    };
  }, []);
  const logout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("username");
    setUser(null);
  };

  return (
    <div className="app-shell">
      <header className="site-header">
        <a className="brand" href="/">
          <span className="brand-mark">J</span>
          <span>
            <strong>Journal</strong>
            <small>JWT Blog</small>
          </span>
        </a>

        <div className="header-actions">
          {user ? (
            <>
              <span className="user-chip">
                <span className="user-avatar">{user.charAt(0).toUpperCase()}</span>
                {user}
              </span>
              <button className="button button-ghost" onClick={logout}>
                Log out
              </button>
            </>
          ) : (
            <span className="header-note">A space for your ideas</span>
          )}
        </div>
      </header>

      <main>
        <section className="hero">
          <div className="hero-copy">
            <span className="eyebrow">YOUR SPACE TO WRITE</span>
            <h1>Ideas worth <em>sharing.</em></h1>
            <p>Write freely, discover new perspectives, and keep your best thoughts in one place.</p>
          </div>
          <div className="hero-decoration" aria-hidden="true">
            <span className="sun"></span>
            <span className="line line-one"></span>
            <span className="line line-two"></span>
          </div>
        </section>

        <section className="content-grid">
          <div className="main-column">
            {user ? (
              <PostForm onCreated={loadPosts} onUnauthorized={logout} />
            ) : (
              <AuthForm onLogin={setUser} />
            )}

            <div className="posts-heading">
              <div>
                <span className="eyebrow">THE COMMUNITY</span>
                <h2>Latest stories</h2>
              </div>
              <span className="post-count">
                {posts.length} {posts.length === 1 ? "story" : "stories"}
              </span>
            </div>

            {postsError && <p className="form-message error">{postsError}</p>}

            {posts.length === 0 && (
              <div className="empty-state">
                <span className="empty-icon">✦</span>
                <h3>No stories yet</h3>
                <p>Be the first to turn an idea into a story.</p>
              </div>
            )}

            <div className="posts-list">
              {posts.map((p) => (
                <article className="post-card" key={p.id}>
                  <div className="post-card-top">
                    <span className="post-tag">FEATURED</span>
                    <time dateTime={p.createdAt}>
                      {new Date(p.createdAt).toLocaleDateString(undefined, {
                        month: "short",
                        day: "numeric",
                        year: "numeric",
                      })}
                    </time>
                  </div>
                  <h3>{p.title}</h3>
                  <p>{p.content}</p>
                  <div className="post-author">
                    <span className="author-avatar">{p.author?.charAt(0).toUpperCase()}</span>
                    <span>By <strong>{p.author}</strong></span>
                  </div>
                </article>
              ))}
            </div>
          </div>

          <aside className="side-panel">
            <div className="quote-card">
              <span className="quote-mark">“</span>
              <p>There is no greater agony than bearing an untold story inside you.</p>
              <span className="quote-author">— Maya Angelou</span>
            </div>
            <div className="about-card">
              <span className="eyebrow">WHY JOURNAL?</span>
              <h3>Make space for what matters.</h3>
              <p>A simple, secure place to capture your thoughts and share them with the world.</p>
            </div>
          </aside>
        </section>
      </main>
      <footer>© 2026 Journal <span>•</span> Write something worth remembering.</footer>
    </div>
  );
};
export default App;
