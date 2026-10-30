import { useState } from "react";
import "./Registration.css";

function Registrstion() {
	const [message, setMessage] = useState("");
	const [empId, setEmpId] = useState("");
	const [empName, setEmpName] = useState("");
	const [email, setEmail] = useState("");
	const [designation, setDesignation] = useState("");
	const [techStack, setTechStack] = useState("");
	const [password, setPassword] = useState("");
	const [isSubmitting, setIsSubmitting] = useState(false);

	async function sendData(event) {
		event.preventDefault();
		setIsSubmitting(true);
		setMessage("");

		try {
			const response = await fetch("http://localhost:8080/v1/user/addemp", {
				method: "POST",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify({
					employeeId: empId,
					name: empName,
					email,
					designation,
					techStack,
					password,
				}),
			});

			const responseMessage = await response.text();
			if (!response.ok) {
				throw new Error(
					responseMessage || `Request failed with status ${response.status}`,
				);
			}

			setMessage(responseMessage || "Employee registered successfully.");
		} catch (error) {
			console.error("Error registering employee:", error);
			setMessage(
				error instanceof TypeError
					? "Could not reach the backend. Check that it is running on port 8080 and that CORS is configured."
					: `Registration failed: ${error.message}`,
			);
		} finally {
			setIsSubmitting(false);
		}
	}

	return (
		<main className="registration-page">
			<form className="registration-form" onSubmit={sendData}>
				<h1>Employee Registration</h1>
				<p className="registration-form__description">
					Enter the employee details below.
				</p>

				<label htmlFor="employee-id">Employee ID</label>
				<input
					id="employee-id"
					name="employeeId"
					type="number"
					value={empId}
					onChange={(event) => setEmpId(event.target.value)}
					autoComplete="off"
					placeholder="Enter employee ID"
					required
				/>
				<label htmlFor="employee-name">Name</label>
				<input
					id="employee-name"
					name="name"
					type="text"
					value={empName}
					onChange={(event) => setEmpName(event.target.value)}
					autoComplete="name"
					placeholder="Enter full name"
					required
				/>

				<label htmlFor="employee-email">Email</label>
				<input
					id="employee-email"
					name="email"
					type="email"
					value={email}
					onChange={(event) => setEmail(event.target.value)}
					autoComplete="email"
					placeholder="name@example.com"
					required
				/>

				<label htmlFor="employee-designation">Designation</label>
				<input
					id="employee-designation"
					name="designation"
					type="text"
					value={designation}
					onChange={(event) => setDesignation(event.target.value)}
					placeholder="Enter designation"
					required
				/>

				<label htmlFor="employee-tech-stack">Tech stack</label>
				<textarea
					id="employee-tech-stack"
					name="techStack"
					value={techStack}
					onChange={(event) => setTechStack(event.target.value)}
					placeholder="e.g. React, Node.js, SQL"
					rows="3"
					required
				/>

				<label htmlFor="employee-password">Password</label>
				<input
					id="employee-password"
					name="password"
					type="password"
					value={password}
					onChange={(event) => setPassword(event.target.value)}
					autoComplete="new-password"
					minLength="8"
					placeholder="At least 8 characters"
					required
				/>

				<button disabled={isSubmitting} type="submit">
					{isSubmitting ? "Registering..." : "Register Employee"}
				</button>
				<p
					className="registration-form__message"
					role="status"
					aria-live="polite"
				>
					{message}
				</p>
			</form>
		</main>
	);
}

export default Registrstion;
