import React, { Component } from 'react';
class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      amount: '',
      currencyType: 'Euro' 
    };
    this.handleAmountChange = this.handleAmountChange.bind(this);
    this.handleCurrencyTypeChange = this.handleCurrencyTypeChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleAmountChange(event) {
    this.setState({
      amount: event.target.value
    });
  }

  handleCurrencyTypeChange(event) {
    this.setState({
      currencyType: event.target.value
    });
  }

  handleSubmit(event) {
    event.preventDefault();
    const amount = parseFloat(this.state.amount);

    if (!isNaN(amount)) {
      const euroValue = amount * 80;
      alert(`Converting to: Euro Amount is ${euroValue}`);
    } else {
      alert('Please enter a valid number for the amount.');
    }
  }

  render() {
    return (
      <div style={{
        marginTop: '30px', 
        fontFamily: 'sans-serif', 
        fontSize: '16px'
      }}>
        <h2 style={{
          color: 'green', 
          fontSize: '2em', 
          marginBottom: '20px', 
          fontWeight: 'bold' 
        }}>Currency Convertor!!!</h2>
        <form onSubmit={this.handleSubmit}>
          <div style={{
            marginBottom: '15px', 
            display: 'flex', 
            alignItems: 'center' 
          }}>
            <label htmlFor="amount" style={{
              marginRight: '10px', 
              minWidth: '70px',
              textAlign: 'right' 
            }}>
              Amount:
            </label>
            <input
              type="text"
              id="amount"
              value={this.state.amount}
              onChange={this.handleAmountChange}
              style={{
                padding: '8px', 
                border: '1px solid #ccc', 
                borderRadius: '4px', 
                flexGrow: '1', 
                fontSize: '1em' 
              }}
            />
          </div>
          <div style={{
            marginBottom: '15px',
            display: 'flex',
            alignItems: 'center'
          }}>
            <label htmlFor="currency" style={{
              marginRight: '10px',
              minWidth: '70px',
              textAlign: 'right'
            }}>
              Currency:
            </label>
            <input
              type="text"
              id="currency"
              value={this.state.currencyType}
              onChange={this.handleCurrencyTypeChange}
              disabled 
              style={{
                padding: '8px',
                border: '1px solid #ccc',
                borderRadius: '4px',
                flexGrow: '1',
                fontSize: '1em',
                backgroundColor: '#f0f0f0' 
              }}
            />
          </div>
    
    
          <div style={{ textAlign: 'center', marginTop: '10px' }}>
            <button type="submit" style={{
              padding: '8px 15px',
              backgroundColor: '#e0e0e0',
              border: '1px solid #c0c0c0',
              borderRadius: '4px',
              cursor: 'pointer',
              fontSize: '1em',
              
            }}>
              Submit
            </button>
          </div>
        </form>
      </div>
    );
  }
}

export default CurrencyConvertor;