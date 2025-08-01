import React from 'react';

function App() {
  const element = "Office Space";
  const jsxatt = <img src="/img22.png" width="25%" height="25%" alt="Office Space" />;
  const ItemName = { Name: "DBS", Rent: 70000, Address: 'Chennai' };

  let colors = [];
  let rentDisplayColor = '';

  if (ItemName.Rent <= 60000) {
    colors.push('textRed');
    rentDisplayColor = 'red';
  } else {
    colors.push('textGreen');
    rentDisplayColor = 'green';
  }

  return (
    <div style={{
      fontFamily: 'Arial, sans-serif',
      display: 'flex',
      flexDirection: 'column',
      alignItems: 'center',
      justifyContent: 'flex-start',
      minHeight: '100vh',
      width: '100%',
      padding: '20px',
      boxSizing: 'border-box',
      backgroundColor: '#f0f0f0'
    }}>
      <h1 style={{
        fontSize: '24px',
        fontWeight: 'bold',
        marginBottom: '20px',
        textAlign: 'center'
      }}>
        {element} , at Affordable Range
      </h1>

      {jsxatt}

      <h1 style={{
        fontSize: '18px',
        fontWeight: 'bold',
        marginBottom: '5px'
      }}>
        Name: {ItemName.Name}
      </h1>

      <h3
        style={{
          fontSize: '16px',
          fontWeight: 'bold',
          marginBottom: '5px',
          color: rentDisplayColor
        }}
      >
        Rent: Rs. {ItemName.Rent}
      </h3>

      <h3 style={{
        fontSize: '16px',
        marginBottom: '5px'
      }}>
        Address: {ItemName.Address}
      </h3>
    </div>
  );
}

export default App;
