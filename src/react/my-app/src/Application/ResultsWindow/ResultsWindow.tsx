import React from 'react'
import './ResultsWindow.css'

interface ResultsWindowProps {
    text: string
}

export class ResultsWindow extends React.Component<ResultsWindowProps> {

    render(): JSX.Element {
        return (
            <div className="resultsWindowBox">
                {this.props.text}
            </div>
        );
    }
}