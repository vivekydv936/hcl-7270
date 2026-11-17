import { useActionState } from "react";
import SubmitButton from "./SubmitButton";
import api from "./api";

const PostForm = ({ onCreated, onUnauthorized }) => {
  const submitAction = async (prev, formData) => {
    const title = formData.get("title")?.trim();
    const content = formData.get("content")?.trim();
    if (!title || !content) {
      return {
        error: "Title and content is required",
        msg: "",
        title: title || "",
        content: content || "",
      };
    }
    try {
      await api.post("/posts", { title, content });
      await onCreated?.();

      return {
        error: null,
        msg: "post created successfully",
        title: "",
        content: "",
      };
    } catch (error) {
      const unauthorized = error.response?.status === 401;
      if (unauthorized) onUnauthorized?.();
      return {
        error: unauthorized
          ? "Your session has expired. Please sign in again."
          :
          error.response?.data?.error ||
          error.response?.data?.message ||
          "failed to create post. Please try again.",
        msg: "",
        title,
        content,
      };
    }
  };
  const [state, formAction, isPending] = useActionState(submitAction, {
    error: null,
    msg: "",
    title: "",
    content: "",
  });
  return (
    <form className="form-card post-form" action={formAction}>
      <div className="form-heading">
        <div>
          <span className="eyebrow">SHARE YOUR THOUGHTS</span>
          <h2>Write a new story</h2>
        </div>
        <span className="pen-icon">✎</span>
      </div>
      <label htmlFor="title">Title</label>
      <input
        type="text"
        name="title"
        id="title"
        placeholder="Give your story a title"
        defaultValue={state.title}
        required
        disabled={isPending}
      />
      <label htmlFor="content">Your story</label>
      <textarea
        name="content"
        id="content"
        placeholder="Tell us what’s on your mind..."
        rows={4}
        defaultValue={state.content}
        required
        disabled={isPending}
      ></textarea>
      <SubmitButton label="Publish story" />
      {state.msg && <p className="form-message success" role="status">{state.msg}</p>}
      {state.error && <p className="form-message error" role="alert">{state.error}</p>}
    </form>
  );
};
export default PostForm;
