import { useFormStatus } from "react-dom";

const SubmitButton = ({ label = "Submit" }) => {
  const { pending } = useFormStatus();

  return (
    <button
      type="submit"
      disabled={pending}
      className={`button w-full flex items-center justify-center gap-2
        px-6 py-3 rounded-lg font-semibold text-white
        shadow-md transition-all duration-300
        focus:outline-none focus:ring-4 focus:ring-blue-300
        ${pending ? "button-loading" : ""}`}
    >
      {pending && (
        <svg className="w-5 h-5 animate-spin" viewBox="0 0 24 24" fill="none">
          <circle
            className="opacity-25"
            cx="12"
            cy="12"
            r="10"
            stroke="currentColor"
            strokeWidth="4"
          />
          <path
            className="opacity-75"
            fill="currentColor"
            d="M4 12a8 8 0 018-8v4a4 4 0 00-4 4H4z"
          />
        </svg>
      )}

      {pending ? "Publishing..." : label}
    </button>
  );
};

export default SubmitButton;
