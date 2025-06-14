import { Link } from "react-router";

const About = () => {
  return (
    <>
      <div>About page...</div>
      <Link to="/?hello=world&molly=YA">Go to home!</Link>
    </>
  );
};

export default About;
