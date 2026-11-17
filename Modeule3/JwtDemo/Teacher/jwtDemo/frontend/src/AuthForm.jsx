import api from "./api";
import SubmitButton from "./SubmitButton";
import { useState, useActionState } from "react";

const AuthForm = ({ onLogin }) => {
  const [mode, setMode] = useState("login");
  const submitAction = async (prevState, formData) => {
    const username = formData.get("username")?.trim();
    const password = formData.get("password")?.trim();

    if (!username || !password) {
      return {
        error: "username and password is required",
        msg: "",
        username: username || "",
      };
    }
    try {
      if (mode == "register") {
        await api.post("/auth/register", { username, password });
        setMode("login");
        return {
          error: null,
          msg: "user registered successfully",
          username,
        };
      }
      // login mode
      const { data } = await api.post("/auth/login", { username, password });
      if (!data.token || !data.username) {
        return {
          error: "Login succeeded but no valid session was returned. Please try again.",
          msg: "",
          username,
        };
      }
      localStorage.setItem("token", data.token);
      localStorage.setItem("username", data.username);
      onLogin(data.username);
      return {
        error: null,
        msg: "",
        username: data.username,
      };
    } catch (error) {
      return {
        error:
          error.response?.data?.error ||
          error.response?.data?.message ||
          "Something went wrong. Please try again.",
        msg: "",
        username,
      };
    }
  };
  const [state, formAction, isPending] = useActionState(submitAction, {
    error: null,
    msg: "",
    username: "",
  });
  return (
    <form className="form-card auth-card" action={formAction}>
      <span className="eyebrow">WELCOME BACK</span>
      <h2>{mode === "login" ? "Sign in to Journal" : "Create your account"}</h2>
      <p className="form-intro">
        {mode === "login" ? "Continue where your ideas left off." : "Start sharing your stories today."}
      </p>
      <label htmlFor="username">Username</label>
      <input
        type="text"
        name="username"
        id="username"
        placeholder="Enter your username"
        defaultValue={state.username}
        required
        disabled={isPending}
      />
      <label htmlFor="password">Password</label>
      <input
        type="password"
        name="password"
        id="password"
        placeholder="Enter your password"
        required
        disabled={isPending}
      />
      <SubmitButton label={mode === "login" ? "Sign in" : "Create account"} />
      <button className="text-button"
        type="button"
        disabled={isPending}
        onClick={() => {
          setMode(mode === "login" ? "register" : "login");
        }}
      >
        {mode === "login" ? "New here? Create an account" : "Already have an account? Sign in"}
      </button>
      {state.msg && <p className="form-message success" role="status">{state.msg}</p>}
      {state.error && <p className="form-message error" role="alert">{state.error}</p>}
    </form>
  );
};
export default AuthForm;
