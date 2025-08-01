import logo from './logo.svg';
import './App.css';
import { CohortsData} from './Cohort'
import CohortDetails from './CohortDetails'; 
import styles from './CohortDetails.module.css';

function App() {
 
  return (
  <div className={styles.container}>
    <div style={{width: '100%', textAlign: 'center', marginBottom: '20px'}}>
      <h1>Cohorts Details</h1>
    </div>
    {CohortsData.map(cohort => <CohortDetails key={cohort.cohortCode} cohort={cohort}/>)}
  </div>
  );
}

export default App;
